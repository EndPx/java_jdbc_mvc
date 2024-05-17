/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOmovie.datamovieDAO;
import tugascrud.DAOimplement.datamovileimplement;
import tugascrud.model.*;
import tugascrud.MainView;
/**
 *
 * @author abaym
 */
public class moviecontroller {
    MainView frame;
    datamovileimplement impldatamovie;
    List<movie> dp;
    
    public moviecontroller(MainView frame){
        this.frame=frame;
        impldatamovie = new datamovieDAO();
        dp = impldatamovie.getAll();
    }
    public void isitabel(){
        dp = impldatamovie.getAll();
        tabelmovie tm = new tabelmovie(dp);
        frame.getTabelData().setModel(tm);
    }
    
    public void insert(){
        movie dp = new movie();
        dp.setJudul(frame.getJudul().getText());
        dp.setAlur(Double.parseDouble(frame.getAlur().getText()));
        dp.setAkting(Double.parseDouble(frame.getAkting().getText()));
        dp.setPenokohan(Double.parseDouble(frame.getPenokohan().getText()));
        dp.setNilai(dp.menghitungNilai());
        impldatamovie.insert(dp);
    }
    
    public void update(){
        movie dp = new movie();
        dp.setJudul(frame.getJudul().getText());
        dp.setAlur(Double.parseDouble(frame.getAlur().getText()));
        dp.setAkting(Double.parseDouble(frame.getAkting().getText()));
        dp.setPenokohan(Double.parseDouble(frame.getPenokohan().getText()));
        dp.setNilai(dp.menghitungNilai());
        impldatamovie.update(dp);
    }
    
    public void delete(){
        movie dp = new movie();
        dp.setJudul(frame.getJudul().getText());
        impldatamovie.delete(dp);
    }
}
