package nustorage.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import nustorage.commons.exceptions.DataConversionException;
import nustorage.model.ReadOnlyAddressBook;
import nustorage.model.ReadOnlyUserPrefs;
import nustorage.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends AddressBookStorage, UserPrefsStorage, FinanceAccountStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getAddressBookFilePath();

    @Override
    Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException, IOException;

    @Override
    void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException;

}
