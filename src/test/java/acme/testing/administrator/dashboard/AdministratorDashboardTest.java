package acme.testing.administrator.dashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorDashboardTest extends AcmePlannerTest{
	
	/* ################################ AdministratorDashboardTest ###################################
	 * 
	 *  Los siguientes atributos no tienen ninguna restricción, por lo que simplemente vamos a nombrarlos.
	 *  
	 *  nTasksPublic, nTasksPrivate, nTasksFinished, nTasksNoFinished, averageWorkload, 
	 *  standardDeviationWorkload, maxWorkload, minWorkload, averageExecutionPeriod, standardDeviationExecutionPeriod, 
	 *  maxExecutionPeriod, minExecutionPeriod.
	 * 
	 *  En esta feature estamos comprobando que inicie sesion como administrador y checkee cada una de las variables de las que 
	 *  dispone esta entidad. Como estamos comprobando casos positivos, estos casos han sido creados con el fin de cumplir las 
	 *  restricciones de cada una de las propiedades descritas anteriormente.
	 * 
	 * 
	 */
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/dashboard-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void showAdministratorDashboardPositive(final String nShoutNoPublic,final String nShoutPublic, final String stdevpShoutaverageEur,final String averageShoutaverageEur, 
		final String stdevpShoutaverageUSD,final String averageShoutaverageUSD,final String nShoutbudget,final String nTasksPublic, final String nTasksPrivate, 
		final String nTasksFinished,final String nTasksNoFinished, final String averageWorkload, 
		final String standardDeviationWorkload, final String maxWorkload, final String minWorkload, final String averageExecutionPeriod,
		final String standardDeviationExecutionPeriod, final String maxExecutionPeriod, final String minExecutionPeriod) {
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");
		super.checkNotPanicExists();
		
		super.checkInputBoxHasValue("nShoutNoPublic", nShoutNoPublic);
		super.checkInputBoxHasValue("nShoutPublic", nShoutPublic);
		super.checkInputBoxHasValue("stdevpShoutaverageEur", stdevpShoutaverageEur);
		super.checkInputBoxHasValue("averageShoutaverageEur", averageShoutaverageEur);
		super.checkInputBoxHasValue("stdevpShoutaverageUSD", stdevpShoutaverageUSD);
		super.checkInputBoxHasValue("averageShoutaverageUSD", averageShoutaverageUSD);
		super.checkInputBoxHasValue("nShoutbudget", nShoutbudget);
		super.checkInputBoxHasValue("nTasksPublic", nTasksPublic);
		super.checkInputBoxHasValue("nTasksPrivate", nTasksPrivate);
		super.checkInputBoxHasValue("nTasksFinished", nTasksFinished);
		super.checkInputBoxHasValue("nTasksNoFinished", nTasksNoFinished);
		super.checkInputBoxHasValue("averageWorkload", averageWorkload);
		super.checkInputBoxHasValue("standardDeviationWorkload", standardDeviationWorkload);
		super.checkInputBoxHasValue("maxWorkload", maxWorkload);
		super.checkInputBoxHasValue("minWorkload", minWorkload);
		super.checkInputBoxHasValue("averageExecutionPeriod", averageExecutionPeriod);
		super.checkInputBoxHasValue("standardDeviationExecutionPeriod", standardDeviationExecutionPeriod);
		super.checkInputBoxHasValue("maxExecutionPeriod", maxExecutionPeriod);
		super.checkInputBoxHasValue("minExecutionPeriod", minExecutionPeriod);
		super.signOut();
	}
}
