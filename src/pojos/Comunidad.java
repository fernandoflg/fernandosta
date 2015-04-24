/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author izquierda
 */
@Entity
@Table(name = "comunidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunidad.findAll", query = "SELECT c FROM Comunidad c"),
    @NamedQuery(name = "Comunidad.findByIdedificio", query = "SELECT c FROM Comunidad c WHERE c.idedificio = :idedificio"),
    @NamedQuery(name = "Comunidad.findByDireccion", query = "SELECT c FROM Comunidad c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Comunidad.findByPoblacion", query = "SELECT c FROM Comunidad c WHERE c.poblacion = :poblacion"),
    @NamedQuery(name = "Comunidad.findByProvincia", query = "SELECT c FROM Comunidad c WHERE c.provincia = :provincia"),
    @NamedQuery(name = "Comunidad.findByCodigopostal", query = "SELECT c FROM Comunidad c WHERE c.codigopostal = :codigopostal"),
    @NamedQuery(name = "Comunidad.findByEmail", query = "SELECT c FROM Comunidad c WHERE c.email = :email"),
    @NamedQuery(name = "Comunidad.findByPresidente", query = "SELECT c FROM Comunidad c WHERE c.presidente = :presidente"),
    @NamedQuery(name = "Comunidad.findBySecretario", query = "SELECT c FROM Comunidad c WHERE c.secretario = :secretario"),
    @NamedQuery(name = "Comunidad.findByTfpresidente", query = "SELECT c FROM Comunidad c WHERE c.tfpresidente = :tfpresidente"),
    @NamedQuery(name = "Comunidad.findByTfsecretario", query = "SELECT c FROM Comunidad c WHERE c.tfsecretario = :tfsecretario"),
    @NamedQuery(name = "Comunidad.findByCuota", query = "SELECT c FROM Comunidad c WHERE c.cuota = :cuota")})
public class Comunidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idedificio")
    private Integer idedificio;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "poblacion")
    private String poblacion;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "codigopostal")
    private Integer codigopostal;
    @Column(name = "email")
    private String email;
    @Column(name = "presidente")
    private String presidente;
    @Column(name = "secretario")
    private String secretario;
    @Column(name = "tfpresidente")
    private Integer tfpresidente;
    @Column(name = "tfsecretario")
    private Integer tfsecretario;
    @Column(name = "cuota")
    private Integer cuota;

    public Comunidad() {
    }

    public Comunidad(Integer idedificio) {
        this.idedificio = idedificio;
    }

    public Integer getIdedificio() {
        return idedificio;
    }

    public void setIdedificio(Integer idedificio) {
        this.idedificio = idedificio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(Integer codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getSecretario() {
        return secretario;
    }

    public void setSecretario(String secretario) {
        this.secretario = secretario;
    }

    public Integer getTfpresidente() {
        return tfpresidente;
    }

    public void setTfpresidente(Integer tfpresidente) {
        this.tfpresidente = tfpresidente;
    }

    public Integer getTfsecretario() {
        return tfsecretario;
    }

    public void setTfsecretario(Integer tfsecretario) {
        this.tfsecretario = tfsecretario;
    }

    public Integer getCuota() {
        return cuota;
    }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idedificio != null ? idedificio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunidad)) {
            return false;
        }
        Comunidad other = (Comunidad) object;
        if ((this.idedificio == null && other.idedificio != null) || (this.idedificio != null && !this.idedificio.equals(other.idedificio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Comunidad[ idedificio=" + idedificio + " ]";
    }
    public ArrayList campos(){
    ArrayList listacampos = new ArrayList();
    listacampos.add("idedificio");
    listacampos.add("presidente");
    listacampos.add("telefonopresidente");
    listacampos.add("secretario");
    listacampos.add("tfsecretario");
    listacampos.add("direccion");
    listacampos.add("poblacion");
    listacampos.add("provincia");
    listacampos.add("codigopostal");
    listacampos.add("email");
    listacampos.add("cuota");
    
    
      
    
    return listacampos;
    }
}
