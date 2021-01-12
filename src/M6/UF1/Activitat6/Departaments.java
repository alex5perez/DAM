package exercici6uf1m6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Departaments {
	
	private Departament[] departaments;
 
	
	public Departament[] getDepartaments() {
		return departaments;
	}
	public void setDepartaments(Departament[] departaments) {
		this.departaments = departaments;
	}
 
}
