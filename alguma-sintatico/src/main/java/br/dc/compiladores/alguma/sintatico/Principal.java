package br.dc.compiladores.alguma.sintatico;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Principal {
    public static void main(String args[]) throws IOException {
        try(PrintWriter pw = new PrintWriter(new File(args[1]))) {

            CharStream cs = CharStreams.fromFileName(args[0]);
            AlgumaLexer lexer = new AlgumaLexer(cs);
    
            /**
            Token t = lexer.nextToken();
            System.out.println(t);

            while( (t = lexer.nextToken()).getType() != Token.EOF) {
                System.out.println("OK");
                System.out.println("<" + AlgumaLexer.VOCABULARY.getDisplayName(t.getType()) + "," + t.getText() + ">");
                
                if(t.equals("SIMBOLO_NAO_RECONHECIDO")) {
                    pw.println("Linha "+t.getLine()+": "+t.getText()+" - simbolo nao identificado");
                    throw new RuntimeException();
                } else if(t.equals("CADEIA_NAO_FECHADA")) {
                    pw.println("Linha "+t.getLine()+": cadeia literal nao fechada");
                    throw new RuntimeException();
                } else if(t.equals("COMENTARIO_NAO_FECHADO")) {
                    pw.println("Linha "+t.getLine()+": comentario nao fechado");
                    throw new RuntimeException();
                }
            }
            */

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            AlgumaParser parser = new AlgumaParser(tokens);
            ErroSintatico errSintatico = new ErroSintatico(pw);
            
            // Remove a mensagem de erro padrão para então adicionar
            // a mensagem de erro personalisada
            parser.removeErrorListeners();
            parser.addErrorListener(errSintatico);
    
            parser.programa();
        } catch(RuntimeException ex) {
            return;
        }
        
    }
}