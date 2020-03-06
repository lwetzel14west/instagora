package com.agora.instagora;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.agora.instagora.service.StoryContentGenerator;

public class StoryCollectionTest {
    
	

    /**
     * @return the suite of tests being tested
     * @throws IOException 
     * @throws FileNotFoundException 
     */
	@Test
    public void test() throws FileNotFoundException, IOException
    {
    	 File f = new File("src/test/resources/test.json");
         byte[] bf = new byte[(int)f.length()];
         new FileInputStream(f).read(bf);
         String fileContent = new String(bf, "UTF-8");
         StoryContentGenerator scg = new StoryContentGenerator();
         scg.contentExtractor(fileContent);
    }
}
