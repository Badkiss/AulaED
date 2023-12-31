package Controlador;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sax {
    public static void mostrar(Path path){
        try {
            SAXParserFactory factory=SAXParserFactory.newInstance();
            SAXParser saxParser=factory.newSAXParser();
            DefaultHandler handler=new DefaultHandler(){
                boolean nombre;
                boolean apellido;
                boolean año;
                boolean fechaNac;
                boolean asignatura;
                public void startElement(String uri, String localName, String qName,Attributes attributes){
                    if(qName.equals("nombre")){
                     nombre=true;
                    }
                    if (qName.equals("apellido")){
                        apellido=true;
                    }
                    if (qName.equals("año")){
                        año=true;
                    }
                    if (qName.equals("asignatura")){
                        String nota=attributes.getValue("nota");
                        String nombre=attributes.getValue("nombre");
                        System.out.println("Asignatura "+nombre+" nota "+nota);
                        asignatura=true;
                    }
                }
                public void endElement(String uri, String localName, String qName){
                                if (qName.equals("alumno")){
                                    System.out.println();
                                    System.out.println();
                                }
                }
                public void characters(char ch[], int start, int length){
                    if(nombre){
                        System.out.println("Alumno");
                        System.out.println(new String(ch,start,length));
                        nombre=false;
                    }
                    if(apellido){
                        System.out.println(new String(ch,start,length));
                        apellido=false;
                    }
                    if (año){
                        System.out.print("Año Cursado ");
                        System.out.println(new String(ch,start,length));
                        año=false;
                    }
                    if (fechaNac){
                        System.out.println(new String(ch,start,length));
                        fechaNac=false;
                    }

                }
            };
            InputStream inputStream= Files.newInputStream(path);
            Reader reader=new InputStreamReader(inputStream,Charset.forName("UTF-8"));
            InputSource inputSource=new InputSource(reader);
            saxParser.parse(inputSource,handler);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void mostrarDom(Path path){
        try {
            SAXParserFactory factory=SAXParserFactory.newInstance();
            SAXParser saxParser=factory.newSAXParser();
            DefaultHandler handler=new DefaultHandler(){
                boolean nombre;
                boolean apellido;
                boolean año;
                boolean fechaNac;
                boolean asignatura;
                String nota="";
                public void startElement(String uri, String localName, String qName,Attributes attributes){
                    if(qName.equals("nombre")){
                        nombre=true;
                    }
                    if (qName.equals("apellido")){
                        apellido=true;
                    }
                    if (qName.equals("año")){
                        año=true;
                    }
                    if (qName.equals("asignatura")){
                         nota=attributes.getValue("nota");;
                        asignatura=true;
                    }
                }
                public void endElement(String uri, String localName, String qName){
                    if (qName.equals("alumno")){
                        System.out.println();
                        System.out.println();
                    }

                }
                public void characters(char ch[], int start, int length){
                    if(nombre){
                        System.out.println("Alumno");
                        System.out.println(new String(ch,start,length));
                        nombre=false;
                    }
                    if(apellido){
                        System.out.println(new String(ch,start,length));
                        apellido=false;
                    }
                    if (año){
                        System.out.print("Año Cursado ");
                        System.out.println(new String(ch,start,length));
                        año=false;
                    }
                    if (fechaNac){
                        System.out.println(new String(ch,start,length));
                        fechaNac=false;
                    }
                    if (asignatura){
                        System.out.println(new String(ch,start,length)+" "+nota);
                        asignatura=false;
                    }

                }
            };
            InputStream inputStream= Files.newInputStream(path);
            Reader reader=new InputStreamReader(inputStream,Charset.forName("UTF-8"));
            InputSource inputSource=new InputSource(reader);
            saxParser.parse(inputSource,handler);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
