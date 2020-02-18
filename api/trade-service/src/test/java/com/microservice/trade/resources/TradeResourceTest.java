package com.microservice.trade.resources;


import com.microservice.trade.TradeApplication;
import com.microservice.trade.builder.TradeBuilder;
import com.microservice.trade.domain.dto.TradeDTO;
import com.microservice.trade.domain.dto.AddressDTO;
import com.microservice.trade.resources.util.TestUtil;
import com.microservice.trade.services.TradeService;
import com.microservice.trade.services.mapper.TradeMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT ,classes = TradeApplication.class)
@Transactional
public class TradeResourceTest {
    public static final String BASE_URL = "/trades/";

    @Autowired
    private TradeBuilder tradeBuilder;

    @Autowired
    private TradeService comercioService;

    @Autowired
    private TradeMapper tradeMapper;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void initializeTest() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Rule
    public ExpectedException excecaoEsperada = ExpectedException.none();

   @Test
    public void insert() throws Exception {
        TradeDTO obj =  tradeBuilder.getTradeDTO();
        executeInsert(obj, status().isCreated());
    }

    @Test
    public void insertInvalidCNJP() throws Exception {
        TradeDTO objDTO = tradeBuilder.getTradeDTO();
        objDTO.setCnpj(null);
        executeInsert(objDTO, status().isBadRequest());
    }

    @Test
    public void insertInvalidNome() throws Exception {
        TradeDTO objDTO = tradeBuilder.getTradeDTO();
        objDTO.setName("Teste");
        executeInsert(objDTO, status().isBadRequest());
    }

    @Test
    public void insertEmptyNome() throws Exception {
        TradeDTO objDTO = tradeBuilder.getTradeDTO();
        objDTO.setName(null);
        executeInsert(objDTO, status().isBadRequest());
    }

    @Test
    public void insertEmptyEndereco() throws Exception {
        TradeDTO objDTO = tradeBuilder.getTradeDTO();
        objDTO.setAddress(null);
        executeInsert(objDTO, status().isBadRequest());
    }

    @Test
    public void insertInvalidEndereco() throws Exception {
        TradeDTO objDTO = tradeBuilder.getTradeDTO();
        objDTO.setAddress(new AddressDTO());
        executeUpdate(objDTO, status().isBadRequest());
    }

    @Test
    public void insertEmptyTelefone() throws Exception {
        TradeDTO objDTO = tradeBuilder.getTradeDTO();
        objDTO.setPhones(new ArrayList<>());
        executeUpdate(objDTO, status().isBadRequest());
    }

    @Test
    public void insertInvalidTelefone() throws Exception {
        TradeDTO objDTO = tradeBuilder.getTradeDTO();
        objDTO.getPhones().get(0).setNumberPhone("1222");
        executeUpdate(objDTO, status().isBadRequest());
    }

    @Test
    public void insertEmptyEmail() throws Exception {
        TradeDTO objDTO = tradeBuilder.getTradeDTO();
        objDTO.setEmails(new ArrayList<>());
        executeUpdate(objDTO, status().isBadRequest());
    }

    @Test
    public void insertInvalidEmail() throws Exception {
        TradeDTO objDTO = tradeBuilder.getTradeDTO();
        objDTO.getEmails().get(0).setEmail("1222");
        executeUpdate(objDTO, status().isBadRequest());
    }

    @Test
    public void update() throws Exception {
        TradeDTO objDTO =  insertService();
        objDTO.setName("Nome diferente do que estava");
        executeUpdate(objDTO, status().isNoContent());
    }

    @Test
    public void updateInvalidCNJP() throws Exception {
        TradeDTO objDTO = insertService();
        objDTO.setCnpj("35435435");
        executeInsert(objDTO, status().isBadRequest());
    }

    @Test
    public void updateInvalidNome() throws Exception {
        TradeDTO objDTO = insertService();
        objDTO.setName("Teste");
        executeUpdate(objDTO, status().isBadRequest());
    }

    @Test
    public void updateEmptyNome() throws Exception {
        TradeDTO objDTO = insertService();
        objDTO.setName(null);
        executeUpdate(objDTO, status().isBadRequest());
    }

    @Test
    public void updateEmptyEndereco() throws Exception {
        TradeDTO objDTO = insertService();
        objDTO.setAddress(null);
        executeUpdate(objDTO, status().isBadRequest());
    }

    @Test
    public void updateInvalidEndereco() throws Exception {
        TradeDTO objDTO = insertService();
        objDTO.setAddress(null);
        executeUpdate(objDTO, status().isBadRequest());
    }

    @Test
    public void updateEmptyTelefone() throws Exception {
        TradeDTO objDTO = insertService();
        objDTO.setPhones(null);
        executeUpdate(objDTO, status().isBadRequest());
    }

    @Test
    public void updateInvalidTelefone() throws Exception {
        TradeDTO objDTO = insertService();
        objDTO.getPhones().get(0).setNumberPhone("1222");
        executeUpdate(objDTO, status().isNoContent()); // oxe
    }

    @Test
    public void updateEmptyEmail() throws Exception {
        TradeDTO objDTO = insertService();
        objDTO.setEmails(null);
        executeUpdate(objDTO, status().isBadRequest());
    }

    @Test
    public void updateInvalidEmail() throws Exception {
        TradeDTO objDTO = tradeBuilder.getTradeDTO();
        objDTO.getEmails().get(0).setEmail("1222");
        executeUpdate(objDTO, status().isBadRequest());
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get(BASE_URL)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(null)))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        TradeDTO objDTO = insertService();
        mockMvc.perform(get(BASE_URL+objDTO.getId())
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(null)))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdInvalidId() throws Exception {
        mockMvc.perform(get(BASE_URL+"8999778787898798798")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(null)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteComercio() throws Exception {
        TradeDTO objDTO = insertService();
        mockMvc.perform(delete(BASE_URL + objDTO.getId()))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteInvalidId() throws Exception {
        mockMvc.perform(delete(BASE_URL +"894839t89485034"))
                .andExpect(status().isBadRequest());
    }

    private void executeInsert(TradeDTO objDTO, ResultMatcher status) throws Exception {
        mockMvc.perform(post(BASE_URL)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(objDTO)))
                .andExpect(status);
    }

    private void executeUpdate(TradeDTO objDTO, ResultMatcher status) throws Exception {
        mockMvc.perform(put(BASE_URL+objDTO.getId())
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(objDTO)))
                .andExpect(status);
    }

    private TradeDTO insertService(){
        TradeDTO objDTO = tradeBuilder.getTradeDTO();
        objDTO.setId(comercioService.insert(objDTO));
        return objDTO;
    }
}
