package com.softuni.exam.io;

import com.softuni.exam.exceptions.DeserializeException;
import com.softuni.exam.exceptions.SerializeException;
import com.softuni.exam.models.dtos.Wrapper;
import org.springframework.stereotype.Component;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by gery on 12.8.2017 г..
 */
@Component
public class XMLSerializer implements Serializer {
    private JAXBContext context;

    public XMLSerializer() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(Class<T> tClass, String path){
        try(InputStream is = this.getClass().getResourceAsStream(path)) {
            this.context = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = this.context.createUnmarshaller();
            return  (T) unmarshaller.unmarshal(is);
        } catch (JAXBException | IOException e) {
            throw new SerializeException(e.getMessage(), e.getCause());
        }
    }

//    public <T> void serialize(T obj, String path) {
//        try(OutputStream os = new FileOutputStream(path)) {
//            this.context = JAXBContext.newInstance(obj.getClass());
//            Marshaller marshaller = this.context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(obj, os);
//        } catch (JAXBException | IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public <T> void serialize(List<T> list, Class<T> obj, String path, String name) {
        try(OutputStream os = new FileOutputStream(path)) {
            this.context = JAXBContext.newInstance(Wrapper.class, obj.getClass());
            Marshaller marshaller = this.context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            QName qName = new QName(name);
            Wrapper wrapper = new Wrapper(list);
            JAXBElement<Wrapper> jaxbElement = new JAXBElement<>(qName, Wrapper.class, wrapper);
            marshaller.marshal(jaxbElement, os);
        } catch (JAXBException | IOException e) {
            throw new DeserializeException(e.getMessage(), e.getCause());
        }
    }
}
