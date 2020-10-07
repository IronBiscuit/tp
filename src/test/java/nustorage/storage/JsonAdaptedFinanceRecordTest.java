package nustorage.storage;


import static nustorage.logic.commands.CommandTestUtil.AMOUNT_1;
import static nustorage.logic.commands.CommandTestUtil.AMOUNT_2;
import static nustorage.logic.commands.CommandTestUtil.AMOUNT_3;
import static nustorage.logic.commands.CommandTestUtil.DATE_TIME_1;
import static nustorage.logic.commands.CommandTestUtil.DATE_TIME_2;
import static nustorage.logic.commands.CommandTestUtil.DATE_TIME_3;
import static nustorage.logic.commands.CommandTestUtil.DATE_TIME_4;
import static nustorage.logic.commands.CommandTestUtil.ID_1;
import static nustorage.logic.commands.CommandTestUtil.ID_2;
import static nustorage.logic.commands.CommandTestUtil.ID_3;
import static nustorage.testutil.Assert.assertThrows;
import static nustorage.testutil.TypicalFinanceRecords.RECORD_A;
import static nustorage.testutil.TypicalFinanceRecords.RECORD_B;
import static nustorage.testutil.TypicalFinanceRecords.RECORD_C;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import nustorage.commons.exceptions.IllegalValueException;
import nustorage.model.record.FinanceRecord;


class JsonAdaptedFinanceRecordTest {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Finance record's %s field is missing!";


    @Test
    void toModelType_validSourceRecordA_returnsFinanceRecord() throws Exception {
        JsonAdaptedFinanceRecord testFinanceRecord = new JsonAdaptedFinanceRecord(RECORD_A);
        assertEquals(RECORD_A, testFinanceRecord.toModelType());
    }


    @Test
    void toModelType_validSourceRecordB_returnsFinanceRecord() throws Exception {
        JsonAdaptedFinanceRecord testFinanceRecord = new JsonAdaptedFinanceRecord(RECORD_B);
        assertEquals(RECORD_B, testFinanceRecord.toModelType());
    }


    @Test
    void toModelType_validSourceRecordC_returnsFinanceRecord() throws Exception {
        JsonAdaptedFinanceRecord testFinanceRecord = new JsonAdaptedFinanceRecord(RECORD_C);
        assertEquals(RECORD_C, testFinanceRecord.toModelType());
    }


    @Test
    void toModelType_validDetails1_returnsFinanceRecord() throws Exception {
        JsonAdaptedFinanceRecord testFinanceRecord = new JsonAdaptedFinanceRecord(ID_1, AMOUNT_1, DATE_TIME_1);
        assertEquals(new FinanceRecord(ID_1, AMOUNT_1, DATE_TIME_1), testFinanceRecord.toModelType());
    }


    @Test
    void toModelType_validDetails2_returnsFinanceRecord() throws Exception {
        JsonAdaptedFinanceRecord testFinanceRecord = new JsonAdaptedFinanceRecord(ID_2, AMOUNT_2, DATE_TIME_2);
        assertEquals(new FinanceRecord(ID_2, AMOUNT_2, DATE_TIME_2), testFinanceRecord.toModelType());
    }


    @Test
    void toModelType_validDetails3_returnsFinanceRecord() throws Exception {
        JsonAdaptedFinanceRecord testFinanceRecord = new JsonAdaptedFinanceRecord(ID_3, AMOUNT_3, DATE_TIME_3);
        assertEquals(new FinanceRecord(ID_3, AMOUNT_3, DATE_TIME_3), testFinanceRecord.toModelType());
    }


    @Test
    void toModelType_invalidAmount_throwsIllegalValueException() {
        JsonAdaptedFinanceRecord testFinanceRecord = new JsonAdaptedFinanceRecord(ID_1, -1, DATE_TIME_4);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, "amount");
        assertThrows(IllegalValueException.class, expectedMessage, testFinanceRecord::toModelType);
    }


    @Test
    void toModelType_invalidDate_throwsIllegalValueException() {
        JsonAdaptedFinanceRecord testFinanceRecord = new JsonAdaptedFinanceRecord(ID_2, AMOUNT_2, null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, "date-time");
        assertThrows(IllegalValueException.class, expectedMessage, testFinanceRecord::toModelType);
    }


}