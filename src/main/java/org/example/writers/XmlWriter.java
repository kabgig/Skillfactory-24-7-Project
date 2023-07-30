package org.example.writers;

import org.example.Root;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDate;

import static org.example.Lgr.logger;
import static org.example.writers.WriteToFile.writeToFile;

public class XmlWriter {
    public void write(Root root) {

        //MARSHALLING------------------------
        StringWriter writer = new StringWriter();
        Marshaller marshaller = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Root.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(root, writer);
            String xmlString = writer.toString();
            String s = LocalDate.now().toString();
            String filePath = "xmlReqs/req_" + s + ".xml";
            //System.out.println(xmlString);
            logger.info("Data is marshalled to XML format");
            writeToFile(xmlString, filePath);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
