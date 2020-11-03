package ru.netology.patient.service.medical;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import ru.netology.patient.entity.BloodPressure;
import ru.netology.patient.entity.HealthInfo;
import ru.netology.patient.entity.PatientInfo;
import ru.netology.patient.repository.PatientInfoFileRepository;
import ru.netology.patient.service.alert.SendAlertService;

import java.math.BigDecimal;
import java.time.LocalDate;



class MedicalServiceImplTest {

    @Test
    void test_Blood_pressure_and_Temperature_Medical_service_ALARM() {

        String id1 = "id1";
        String alarm = "Warning, patient with id: id1, need help";

        PatientInfoFileRepository patientInfoFileRepositoryMock = Mockito.mock(PatientInfoFileRepository.class);

        HealthInfo patientHealfInfo1 = new HealthInfo(new BigDecimal("36.6"), new BloodPressure(125, 78));
        PatientInfo patientInfo1 = new PatientInfo(id1, "Иван", "Петров",
                LocalDate.of(1980, 11, 26), patientHealfInfo1);

        Mockito.when(patientInfoFileRepositoryMock.getById(id1))
                .thenReturn(patientInfo1);

        SendAlertService alertServiceMock = Mockito.mock(SendAlertService.class);

        Mockito.doAnswer((Answer<Void>) invocationOnMock -> {
            System.out.println(alarm);
            return null;
        }).when(alertServiceMock).send(Mockito.any());


        MedicalService medicalService = new MedicalServiceImpl(patientInfoFileRepositoryMock, alertServiceMock);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        System.out.println("Test1 start");

        BloodPressure currentPressure = new BloodPressure(60, 120);
        medicalService.checkBloodPressure(id1, currentPressure);

        BigDecimal currentTemperature = new BigDecimal("10");
        medicalService.checkTemperature(id1, currentTemperature);

        Mockito.verify(alertServiceMock).send(argumentCaptor.capture());

        Assertions.assertEquals(argumentCaptor.getValue(), alarm);

        Mockito.verify(alertServiceMock, Mockito.times(2)).send(Mockito.any());

        System.out.println("Test1 finish");
    }

    @Test
    void test_Temperature_Medical_service_ALARM() {

        String id1 = "id1";
        String alarm = "Warning, patient with id: id1, need help";

        PatientInfoFileRepository patientInfoFileRepositoryMock = Mockito.mock(PatientInfoFileRepository.class);

        HealthInfo patientHealfInfo1 = new HealthInfo(new BigDecimal("36.6"), new BloodPressure(125, 78));
        PatientInfo patientInfo1 = new PatientInfo(id1, "Иван", "Петров",
                LocalDate.of(1980, 11, 26), patientHealfInfo1);

        Mockito.when(patientInfoFileRepositoryMock.getById(id1))
                .thenReturn(patientInfo1);

        SendAlertService alertServiceMock = Mockito.mock(SendAlertService.class);

        Mockito.doAnswer((Answer<Void>) invocationOnMock -> {
            System.out.println(alarm);
            return null;
        }).when(alertServiceMock).send(Mockito.any());

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        MedicalService medicalService = new MedicalServiceImpl(patientInfoFileRepositoryMock, alertServiceMock);

        System.out.println("Test2 start");

        BigDecimal currentTemperature = new BigDecimal("10");
        medicalService.checkTemperature(id1, currentTemperature);

        Mockito.verify(alertServiceMock).send(argumentCaptor.capture());

        Assertions.assertEquals(argumentCaptor.getValue(), alarm);

        Mockito.verify(alertServiceMock, Mockito.times(1)).send(Mockito.any());

        System.out.println("Test2 finish");
    }
    @Test
    void test_Blood_Pressure_Medical_service_ALARM() {

        String id1 = "id1";
        String alarm = "Warning, patient with id: id1, need help";

        PatientInfoFileRepository patientInfoFileRepositoryMock = Mockito.mock(PatientInfoFileRepository.class);

        HealthInfo patientHealfInfo1 = new HealthInfo(new BigDecimal("36.6"), new BloodPressure(125, 78));
        PatientInfo patientInfo1 = new PatientInfo(id1, "Иван", "Петров",
                LocalDate.of(1980, 11, 26), patientHealfInfo1);

        Mockito.when(patientInfoFileRepositoryMock.getById(id1))
                .thenReturn(patientInfo1);

        SendAlertService alertServiceMock = Mockito.mock(SendAlertService.class);

        Mockito.doAnswer((Answer<Void>) invocationOnMock -> {
            System.out.println(alarm);
            return null;
        }).when(alertServiceMock).send(Mockito.any());

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        MedicalService medicalService = new MedicalServiceImpl(patientInfoFileRepositoryMock, alertServiceMock);

        System.out.println("Test3 start");

        BloodPressure currentPressure = new BloodPressure(60, 120);
        medicalService.checkBloodPressure(id1, currentPressure);

        Mockito.verify(alertServiceMock).send(argumentCaptor.capture());

        Assertions.assertEquals(argumentCaptor.getValue(), alarm);

        Mockito.verify(alertServiceMock, Mockito.times(1)).send(Mockito.any());

        System.out.println("Test3 finish");
    }
    @Test
    void test_Temperature_and_Blood_Pressure_Medical_service_SUCCESS() {

        String id1 = "id1";
        String alarm = "Warning, patient with id: id1, need help";

        PatientInfoFileRepository patientInfoFileRepositoryMock = Mockito.mock(PatientInfoFileRepository.class);

        HealthInfo patientHealfInfo1 = new HealthInfo(new BigDecimal("36.6"), new BloodPressure(125, 78));
        PatientInfo patientInfo1 = new PatientInfo(id1, "Иван", "Петров",
                LocalDate.of(1980, 11, 26), patientHealfInfo1);

        Mockito.when(patientInfoFileRepositoryMock.getById(id1))
                .thenReturn(patientInfo1);

        SendAlertService alertServiceMock = Mockito.mock(SendAlertService.class);

        Mockito.doAnswer((Answer<Void>) invocationOnMock -> {
            System.out.println(alarm);
            return null;
        }).when(alertServiceMock).send(Mockito.any());


        MedicalService medicalService = new MedicalServiceImpl(patientInfoFileRepositoryMock, alertServiceMock);

        System.out.println("Test4 start");

        BigDecimal currentTemperature2 = new BigDecimal("36.6");
        medicalService.checkTemperature(id1, currentTemperature2);

        BloodPressure currentPressure2 = new BloodPressure(125, 78);
        medicalService.checkBloodPressure(id1, currentPressure2);

        Mockito.verify(alertServiceMock, Mockito.times(0)).send(Mockito.any());

        System.out.println("Test4 finish");
    }

}


