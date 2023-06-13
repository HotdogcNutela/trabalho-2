package br.dc.compiladores.alguma.sintatico;

import java.io.PrintWriter;
import java.util.BitSet;

import javax.management.RuntimeErrorException;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class ErroSintatico implements ANTLRErrorListener {
    PrintWriter pw;
    public ErroSintatico(PrintWriter pw) {
        this.pw = pw;
    }
    
    @Override
    public void	reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        // Sem alteracoes
    }
    
    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
        // Sem alteracoes
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        // Sem alteracoes
    }

    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {

        Token t = (Token) offendingSymbol;

        if (t.getText() == "<EOF>") {
            pw.println("Linha "+line+": erro sintatico proximo a EOF");
            pw.println("Fim da compilacao");
            throw new RuntimeException();
        } else {
            pw.println("Linha "+line+": erro sintatico proximo a "+t.getText());
            pw.println("Fim da compilacao");
            throw new RuntimeException();
        }
    }
}
