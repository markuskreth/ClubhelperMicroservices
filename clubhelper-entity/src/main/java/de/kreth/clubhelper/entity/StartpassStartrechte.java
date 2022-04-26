package de.kreth.clubhelper.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the startpass_startrechte database table.
 * 
 */
@Entity
@Table(name = "startpass_startrechte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class StartpassStartrechte extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2093629121995635551L;

    private String fachgebiet;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "startrecht_beginn")
    private Date startrechtBeginn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "startrecht_ende")
    private Date startrechtEnde;

    @Column(name = "verein_name")
    private String vereinName;

    // bi-directional many-to-one association to Startpaesse
    @ManyToOne
    @JoinColumn(name = "startpass_id")
    private Startpass startpaesse;

    public Date getStartrechtBeginn() {
	if (this.startrechtBeginn == null) {
	    return null;
	}
	return new Date(this.startrechtBeginn.getTime());
    }

    public Date getStartrechtEnde() {
	if (this.startrechtEnde == null) {
	    return null;
	}
	return new Date(this.startrechtEnde.getTime());
    }

    public void setStartrechtEnde(Date startrechtEnde) {
	this.startrechtEnde = startrechtEnde;
    }

    public String getFachgebiet() {
	return fachgebiet;
    }

    public void setFachgebiet(String fachgebiet) {
	this.fachgebiet = fachgebiet;
    }

    public String getVereinName() {
	return vereinName;
    }

    public void setVereinName(String vereinName) {
	this.vereinName = vereinName;
    }

    public Startpass getStartpaesse() {
	return startpaesse;
    }

    public void setStartpaesse(Startpass startpaesse) {
	this.startpaesse = startpaesse;
    }

    public void setStartrechtBeginn(Date startrechtBeginn) {
	this.startrechtBeginn = startrechtBeginn;
    }

    @Override
    public int hashCode() {
	final int prime = 97;
	int result = super.hashCode();
	result = prime * result;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	return super.equals(obj);
    }

    @Override
    public String toString() {
	return "StartpassStartrechte [fachgebiet=" + fachgebiet + ", startrechtBeginn=" + startrechtBeginn
		+ ", startrechtEnde=" + startrechtEnde + ", vereinName=" + vereinName + ", startpaesse=" + startpaesse
		+ "]";
    }

}
