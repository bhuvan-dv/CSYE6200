package edu.neu.csye6200;

import java.time.Instant;
import java.util.Date;

public class ElectronicItem extends Item{
    Date warrantyEndDate;
    Date WarrantyStartDate;
    public ElectronicItem(String csvString)
    {
        String[] strValues = csvString.split(",");
        this.ID = Integer.parseInt(strValues[0]);
        this.Name = strValues[1];
        this.Price = Double.parseDouble(strValues[2]);
        this.WarrantyStartDate = Date.from(Instant.parse(strValues[3]));
        this.warrantyEndDate = Date.from(Instant.parse(strValues[4]));
    }

    public void setWarrantyEndDate(Date warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
    }

    public void setWarrantyStartDate(Date warrantyStartDate) {
        WarrantyStartDate = warrantyStartDate;
    }

    public ElectronicItem(){}

    public Date getwarrentyEndDate() {
        return warrantyEndDate;
    }

    public Date getWarrentyStartDate() {
        return WarrantyStartDate;
    }

    public void setWarrentyStartDate(Date warrentyStartDate) {
        WarrantyStartDate = warrentyStartDate;
    }

    public void setWarrentyEndDate(Date warrentyEndDate) {
        this.warrantyEndDate = warrentyEndDate;
    }

    @Override
    public String toString() {
        return super.toString() + ";    Warranty Start Date: " + this.getWarrentyStartDate() + ";    Warranty End Date: " + this.getwarrentyEndDate();
    }
}