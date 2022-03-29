package dna;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;

public class DnaSequenceTest {
    DnaSequence dnaSequence;
    DNACodon dnaCodon;
    @Before
    public void setUp() throws Exception {
        dnaSequence = new DnaSequence();
    }

    
    //Normal case
    @Test
    public void transcribe1() {
    	LinkedList<String> after = new LinkedList<String>();
    	after.add("ala");
    	after.add("arg");
    	after.add("asn");
    	after.add("lle");
    	after.add("gly");
    	after.add("tyr");
    	after.add("arg");
        // TODO: implement tests
        assertEquals(after, this.dnaSequence.transcribe("GCTCGCAACATCGGATATAGA"));
    }
    
    //Special case (still linkedlist [ala, arg, asn, lle, gly, tyr, arg], but the gene is "GCTCGCAACATCGGATATAGAAX" (AX is a bad size codon))
    @Test
    public void transcribe2() {
    	LinkedList<String> after = new LinkedList<String>();
    	after.add("ala");
    	after.add("arg");
    	after.add("asn");
    	after.add("lle");
    	after.add("gly");
    	after.add("tyr");
    	after.add("arg");
    	String dna = "GCTCGCAACATCGGATATAGAAX";
        // TODO: implement tests
    	assertEquals(23, dna.length());
        assertEquals(after, this.dnaSequence.transcribe("GCTCGCAACATCGGATATAGAAX"));
    }
    
    //Special case
    @Test
    public void transcribe3() {
    	LinkedList<String> after = new LinkedList<String>();
    	after.add("ala");
    	String dna = "GCTXCGC";
        // TODO: implement tests
    	assertEquals(7, dna.length());
        assertEquals(after, this.dnaSequence.transcribe("GCTXCGC"));
    }
    
    //Special case
    @Test
    public void transcribe4() {
    	LinkedList<String> after = new LinkedList<String>();
    	String dna = "GX";
    	assertEquals(2, dna.length());
        assertEquals(after, this.dnaSequence.transcribe("GX"));
    }
}