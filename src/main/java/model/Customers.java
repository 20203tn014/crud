package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers {
        @XmlElement
        private int customerNumber;
        @XmlElement
        private String customerName;
        @XmlElement
        private String contactLastName;
        @XmlElement
        private String contactFirstName;
        @XmlElement
        private String phone;
        @XmlElement
        private String addressLine1;
        @XmlElement
        private String addressLine2;
        @XmlElement
        private String city;
        @XmlElement
        private String state;
        @XmlElement
        private String postalCode;
        @XmlElement
        private String country;
        @XmlElement
        private int salesRepEmployeeNumber;
        @XmlElement
        private double creditLimit;

        public Customers(){ }

        public int getCustomerNumber() {
                return customerNumber;
        }

        public void setCustomerNumber(int customerNumber) {
                this.customerNumber = customerNumber;
        }

        public String getCustomerName() {
                return customerName;
        }

        public void setCustomerName(String customerName) {
                this.customerName = customerName;
        }

        public String getContactLastName() {
                return contactLastName;
        }

        public void setContactLastName(String contactLastName) {
                this.contactLastName = contactLastName;
        }

        public String getContactFirstName() {
                return contactFirstName;
        }

        public void setContactFirstName(String contactFirstName) {
                this.contactFirstName = contactFirstName;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getAddressLine1() {
                return addressLine1;
        }

        public void setAddressLine1(String addressLine1) {
                this.addressLine1 = addressLine1;
        }

        public String getAddressLine2() {
                return addressLine2;
        }

        public void setAddressLine2(String addressLine2) {
                this.addressLine2 = addressLine2;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public String getPostalCode() {
                return postalCode;
        }

        public void setPostalCode(String postalCode) {
                this.postalCode = postalCode;
        }

        public String getCountry() {
                return country;
        }

        public void setCountry(String country) {
                this.country = country;
        }

        public int getSalesRepEmployeeNumber() {
                return salesRepEmployeeNumber;
        }

        public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
                this.salesRepEmployeeNumber = salesRepEmployeeNumber;
        }

        public double getCreditLimit() {
                return creditLimit;
        }

        public void setCreditLimit(double creditLimit) {
                this.creditLimit = creditLimit;
        }

}
