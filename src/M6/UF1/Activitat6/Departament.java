package exercici6uf1m6;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@XmlRootElement(name = "Alumne")

//@XmlAccessorType(XmlAccessType.FIELD) // This line was added
class Departament {
        
        private int id;
        private int DEPT_NO;	
        private String NOMBRE;
        private String CURS;
 
        @XmlAttribute(name="id")        
        public int getId() {
		return this.id;
	}

		public int getDEPT_NO() {
			return DEPT_NO;
		}

		public void setDEPT_NO(int dEPT_NO) {
			DEPT_NO = dEPT_NO;
		}

		public String getNOMBRE() {
			return NOMBRE;
		}

		public void setNOMBRE(String nOMBRE) {
			NOMBRE = nOMBRE;
		}

		public String getCURS() {
			return CURS;
		}

		public void setCURS(String cURS) {
			CURS = cURS;
		}

		public void setId(int id) {
			this.id = id;
		}        
    
        
}
