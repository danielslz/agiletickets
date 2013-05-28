package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {

	private Sessao sessao;

	@Before
	public void setup() {
		sessao = new Sessao();
	}

	@Test
	public void deveVenderIngressoSeNumeroDeVagasMaiorQueReservas() throws Exception {
        sessao.setTotalIngressos(2);
        Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVenderIngressoSeNumeroDeVagasMenorQueReservas() throws Exception {
		sessao.setTotalIngressos(2);
		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void deveVenderIngressoSeNumeroDeVagasIgualDeReservas() throws Exception {
		sessao.setTotalIngressos(3);
		Assert.assertTrue(sessao.podeReservar(3));
	}
	
	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		sessao.setTotalIngressos(5);
		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
}
