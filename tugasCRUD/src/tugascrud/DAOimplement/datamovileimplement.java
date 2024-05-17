/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugascrud.DAOimplement;
import java.util.List;
import tugascrud.model.*;
/**
 *
 * @author abaym
 */
public interface datamovileimplement {
    public void insert(movie m);
    public void update(movie m);
    public void delete(movie m);
    public List<movie> getAll();
}