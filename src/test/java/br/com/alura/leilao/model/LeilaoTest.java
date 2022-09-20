package br.com.alura.leilao.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class LeilaoTest {

	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		assertEquals(0, leilao.getLances().size());
		
		BigDecimal doisMil = new BigDecimal("2000.0");
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), doisMil));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(doisMil, leilao.getLances().get(0).getValor());
	}
}
