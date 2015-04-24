/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx_jpa;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javax.persistence.EntityManager;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pojos.Comunidad;

public class JpaController implements Initializable {

    @FXML
    private TextField cidedificio;
    @FXML
    private TextField cdireccion;
    @FXML
    private TextField cpoblacion;
    @FXML
    private TextField cprovincia;
    @FXML
    private TextField ccodigopostal;
    @FXML
    private TextField cemail;
    @FXML
    private TextField cpresidente;
    @FXML
    private TextField csecretario;
    @FXML
    private TextField ctelefonopresidente;
    @FXML
    private TextField ctelefonosecretario;
    @FXML
    private TextField ccuota;
    @FXML
    TableView TablaRegistros;

    private EntityManager em = null;
    private pojos.Comunidad registro = null;
    private Query consulta = null;

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("FX_JPAPU", System.getProperties());
        em = factory.createEntityManager();
        //   em.getTransaction().begin();

        Primerregistro();
        /* Query consulta = em.createQuery("SELECT cc FROM Comunidad cc WHERE cc.idedificio> ?1", pojos.Comunidad.class);

         // consulta.setParameter(1, Integer.parseInt(condicion)).getSingleResult();
         consulta.setParameter(1,0).getSingleResult();*/
    }

    @FXML
    public void Primerregistro() {
        consulta = em.createQuery("SELECT cc FROM Comunidad cc WHERE cc.idedificio>= ?1", pojos.Comunidad.class);

        // consulta.setParameter(1, Integer.parseInt(condicion)).getSingleResult();
        //  consulta.setParameter(1,1212).getSingleResult();
        consulta.setParameter(1, 0).getResultList();
        java.util.Collection data = consulta.getResultList();

        // pojos.Comunidad cccc = (pojos.Comunidad) consulta.getSingleResult();
        registro = (pojos.Comunidad) consulta.getResultList().listIterator().next();
        //  javax.swing.JOptionPane.showMessageDialog(null, "Nombre " + registro.getPresidente());
        visualiza_Registro();
    }

    @FXML
    public void Ultimoregistro() {
        consulta = em.createQuery("SELECT cc FROM Comunidad cc WHERE cc.idedificio>= ?1", pojos.Comunidad.class);

        // consulta.setParameter(1, Integer.parseInt(condicion)).getSingleResult();
        //  consulta.setParameter(1,1212).getSingleResult();
        consulta.setParameter(1, 0).getResultList();
        java.util.Collection data = consulta.getResultList();
        // javax.swing.JOptionPane.showMessageDialog(null, data.size());
        registro = (Comunidad) data.toArray()[data.size() - 1];
        // pojos.Comunidad cccc = (pojos.Comunidad) consulta.getSingleResult();
        // registro= (pojos.Comunidad) consulta.getResultList().listIterator().next();
        // javax.swing.JOptionPane.showMessageDialog(null, "Nombre " + registro.getPresidente());
        visualiza_Registro();
    }

    @FXML
    public void Siguienteregistro() {
        consulta = em.createQuery("SELECT cc FROM Comunidad cc WHERE cc.idedificio> ?1", pojos.Comunidad.class);
        int actual = registro.getIdedificio();
        consulta.setParameter(1, actual).getResultList();
        try {
            registro = (pojos.Comunidad) consulta.getResultList().listIterator().next();
        } catch (Exception ex) {
        }

        //  javax.swing.JOptionPane.showMessageDialog(null, "Nombre " + registro.getPresidente());
        visualiza_Registro();
    }

    @FXML
    public void Anteriorregistro() {
        consulta = em.createQuery("SELECT cc FROM Comunidad cc WHERE cc.idedificio< ?1", pojos.Comunidad.class);
        int actual = registro.getIdedificio();
        consulta.setParameter(1, actual).getResultList();
        java.util.Collection data = consulta.getResultList();
        // javax.swing.JOptionPane.showMessageDialog(null, data.size());
        try {
            registro = (Comunidad) data.toArray()[data.size() - 1];

        } catch (Exception ex) {
        }

        //  javax.swing.JOptionPane.showMessageDialog(null, "Nombre " + registro.getPresidente());
        visualiza_Registro();
    }

    void visualiza_Registro() {

        cidedificio.setText(registro.getIdedificio() + "");
        cdireccion.setText(registro.getDireccion() + "");
        cpoblacion.setText(registro.getPoblacion() + "");
        cprovincia.setText(registro.getProvincia() + "");
        ccodigopostal.setText(registro.getCodigopostal() + "");
        cemail.setText(registro.getEmail() + "");
        cpresidente.setText(registro.getPresidente() + "");
        csecretario.setText(registro.getSecretario() + "");
        ctelefonopresidente.setText(registro.getTfpresidente() + "");
        ctelefonosecretario.setText(registro.getTfsecretario() + "");
        ccuota.setText(registro.getCuota() + "");
    }

    @FXML
    public void Eliminaregistro() {
        em.getTransaction().begin();
        em.remove(registro);
        em.flush();
        em.getTransaction().commit();
    }

    @FXML
    public void Grabaregistro() {
        em.getTransaction().begin();
        registro.setIdedificio(Integer.parseInt(cidedificio.getText()));
        registro.setPresidente(cpresidente.getText());
        registro.setTfpresidente(Integer.parseInt(ctelefonopresidente.getText()));
        registro.setSecretario(csecretario.getText());
        registro.setDireccion(cdireccion.getText());
        registro.setPoblacion(cpoblacion.getText());
        registro.setProvincia(cprovincia.getText());
        registro.setCodigopostal(Integer.parseInt(ccodigopostal.getText()));
        registro.setEmail(cemail.getText());
        registro.setCuota(Integer.parseInt(ccuota.getText()));
        em.persist(registro);
        em.flush();
        em.getTransaction().commit();
    }

    @FXML
    public void Nuevoregistro() {

        cidedificio.setText("");
        cdireccion.setText("");
        cpoblacion.setText("");
        cprovincia.setText("");
        ccodigopostal.setText("");
        cemail.setText("");
        cpresidente.setText("");
        csecretario.setText("");
        ctelefonopresidente.setText("");
        ctelefonosecretario.setText("");
        ccuota.setText("");
        registro = new pojos.Comunidad();
    }

    @FXML
    private void VisualizaRejilla() {
         TablaRegistros.getColumns().clear();
         TablaRegistros.setVisible(!TablaRegistros.isVisible());
        consulta = em.createQuery("SELECT cc FROM Comunidad cc WHERE cc.idedificio>= ?1", pojos.Comunidad.class);

        // consulta.setParameter(1, Integer.parseInt(condicion)).getSingleResult();
        //  consulta.setParameter(1,1212).getSingleResult();
        consulta.setParameter(1, 0).getResultList();
        java.util.Collection data = consulta.getResultList();
        

        //javax.swing.JOptionPane.showMessageDialog(null,data.size());
        ArrayList listaCampos = new ArrayList();
        listaCampos = registro.campos();
 
         if (TablaRegistros.isVisible()) {
        try {

            for (int i = 0; i < listaCampos.size(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;

                // javax.swing.JOptionPane.showMessageDialog(null,listaCampos.get(i));
                TableColumn col = new TableColumn((String) listaCampos.get(i));
                col.setMaxWidth(100);
                col.setMinWidth(100);
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                TablaRegistros.getColumns().addAll(col);

                //    System.out.println("Column ["+i+"] ");
            }
            List ll = new LinkedList();

            Iterator itr = data.iterator();
            while (itr.hasNext()) {
                Comunidad element = (Comunidad) itr.next();

                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(element.getIdedificio().toString());
                row.add(element.getPresidente().toString());
                row.add(element.getTfpresidente().toString());
                row.add(element.getSecretario().toString());
                row.add(element.getSecretario().toString());
//           row.add(element.getTfsecretario().toString());
                row.add(element.getDireccion().toString());
                row.add(element.getPoblacion().toString());
                row.add(element.getProvincia().toString());
                row.add(element.getCodigopostal().toString());
                row.add(element.getEmail().toString());
                row.add(element.getCuota().toString());
                System.out.println(element.getTfsecretario().toString() + " " + row);
                ll.add(row);
            }

            TablaRegistros.getItems().setAll(ll);

        } catch (Exception ex) {
            Logger.getLogger(JpaController.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
    }
     @FXML
    private void FilaRejilla() {
    //System.out.println( TablaRegistros.getSelectionModel().getSelectedIndex());
    //System.out.println(  TablaRegistros.getItems().get(TablaRegistros.getSelectionModel().getSelectedIndex()));
     
    String[] aa=  (TablaRegistros.getItems().get(TablaRegistros.getSelectionModel().getSelectedIndex())).toString().split(",");
    String dato = aa[0].substring(1) ;
    int datoi = Integer.parseInt(dato);
    // System.out.println("Dato"+  dato+"--"+datoi);
    consulta = em.createQuery("SELECT cc FROM Comunidad cc WHERE cc.idedificio>= ?1", pojos.Comunidad.class);
 
        consulta.setParameter(1, datoi).getResultList();
        java.util.Collection data = consulta.getResultList();

        // pojos.Comunidad cccc = (pojos.Comunidad) consulta.getSingleResult();
        registro = (pojos.Comunidad) consulta.getResultList().listIterator().next();
        //  javax.swing.JOptionPane.showMessageDialog(null, "Nombre " + registro.getPresidente());
        visualiza_Registro();
 
   
    }
}
