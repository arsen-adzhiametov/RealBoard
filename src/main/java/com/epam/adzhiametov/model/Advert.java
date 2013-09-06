package com.epam.adzhiametov.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by Arsen Adzhiametov on 7/31/13.
 */
@Entity
public class Advert {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "id_generator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "id_generator", sequenceName = "ADVERT_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "SECTION")
    private String section;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "TIME")
    private Calendar time;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "CONTRACT")
    private Boolean contract;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getContract() {
        return contract;
    }

    public void setContract(Boolean contract) {
        this.contract = contract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar calendar) {
        this.time = calendar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Advert)) return false;

        Advert advert = (Advert) o;

        if (contract != null ? !contract.equals(advert.contract) : advert.contract != null) return false;
        if (name != null ? !name.equals(advert.name) : advert.name != null) return false;
        if (phone != null ? !phone.equals(advert.phone) : advert.phone != null) return false;
        if (price != null ? !price.equals(advert.price) : advert.price != null) return false;
        if (section != null ? !section.equals(advert.section) : advert.section != null) return false;
        if (text != null ? !text.equals(advert.text) : advert.text != null) return false;
        if (title != null ? !title.equals(advert.title) : advert.title != null) return false;
        if (type != null ? !type.equals(advert.type) : advert.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (section != null ? section.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (contract != null ? contract.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Advert{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", section='" + section + '\'' +
                ", title='" + title + '\'' +
                ", calendar=" + time +
                ", text='" + text + '\'' +
                ", price=" + price +
                ", contract=" + contract +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
