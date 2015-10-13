/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class SpelServiceTest {
    private SpelService spelService;
    private SpelService spelServiceComplex;
    
    @Before
    public void before(){
        spelService = new SpelService();
        spelServiceComplex = new SpelService(10, 4, 1, 4, 6, 2);
    }
    
    @Test
    public void nieuwSpelServiceIsNotNull(){
        Assert.assertNotNull(spelService);
    }
    
    @Test
    public void nieuwSpelServiceComplexIsNotNull(){
        Assert.assertNotNull(spelServiceComplex);
    }
    
    @Test
    public void nieuwSpelServiceTerrariumIsNotNull(){
        Assert.assertNotNull(spelService.getTerrarium());
    }
    
    @Test
    public void nieuwSpelServiceComplexTerrariumIsNotNull(){
        Assert.assertNotNull(spelServiceComplex.getTerrarium());
    }
    
    @Test
    public void spelServiceNieuweDagMethode(){
        spelService.nieuweDag();
        Assert.assertEquals(2, spelService.getTerrarium().getDag());
    }
    
    @Test
    public void spelServiceComplexNieuweDagMethode(){
        spelServiceComplex.nieuweDag();
        Assert.assertEquals(2, spelServiceComplex.getTerrarium().getDag());
    }
}
