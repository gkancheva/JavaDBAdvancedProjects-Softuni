package com.softuni.io;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created on 5.8.2017 г..
 */
@Component
public class XMLParser implements Parser {
    private JAXBContext context;

    public XMLParser() {
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> tClass, String path){
        T object = null;
        try(InputStream is = this.getClass().getResourceAsStream(path)) {
            this.context = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = this.context.createUnmarshaller();
            object = (T) unmarshaller.unmarshal(is);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    public <T> void writeObject(T obj, String path) {
        try(OutputStream os = new FileOutputStream(path)) {
            this.context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = this.context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(obj, os);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
