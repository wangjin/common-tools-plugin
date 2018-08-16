package com.github.wangjin252.commontools.util;

import com.github.wangjin252.commontools.entity.Pom;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.io.File;
import java.io.FileInputStream;

public class PomUtil {


    public static Pom parse(String pomPath) throws Exception {


        JAXBContext jaxbContext = JAXBContext.newInstance(Pom.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setNamespaceAware(false);
        XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();
        SAXSource saxSource = new SAXSource(xmlReader, new InputSource(new FileInputStream(new File(pomPath + File.separator + "pom.xml"))));
        return (Pom) unmarshaller.unmarshal(saxSource);

    }
}
