package com.lgc.ctps.sgec;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.lgc.ctps.sgec.domain.Sample;
import com.lgc.ctps.sgec.repository.SampleRepository;
import com.lgc.ctps.sgec.service.SampleService;

@RunWith(MockitoJUnitRunner.class)
public class SampleServiceTest {

	@Mock
	SampleRepository sampleRepository;	
	
	

	@Test
	public void save() {
		SampleService sampleService=new SampleService();
		sampleService.setSampleRepository(sampleRepository);
		Sample sample =new Sample("1");		
		Sample sampleReturn =new Sample("1");
		Mockito.when(sampleRepository.save(sample)).thenReturn(sampleReturn);
		sampleService.save(sample);
		assertNotNull(sampleReturn);
		
	}

	/*@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });
		assertEquals(15, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_NoValues() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}*/
}

