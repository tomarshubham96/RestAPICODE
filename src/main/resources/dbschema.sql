

CREATE TABLE IF NOT EXISTS GlobalDB(
    GDBPHONE_NUMBER VARCHAR(255) NOT NULL,
    GDB_EMAIL_ID VARCHAR(255),
    GDB_NAME VARCHAR(255) NOT NULL,
	IS_REGISTERED BOOLEAN,
    IS_SPAM BOOLEAN 
);

CREATE TABLE IF NOT EXISTS USER(
    PHONE_NUMBER VARCHAR(255) NOT NULL,
    EMAIL_ID VARCHAR(255),
    NAME VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS CONTACT(
    CONTACT_NUMBER VARCHAR(255) NOT NULL,
    CONTACT_EMAIL_ID VARCHAR(255),
    CONTACT_NAME VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS USER_CONTACTS(
    PHONE_NUMBER VARCHAR(255) NOT NULL,
	CONTACT_NUMBER VARCHAR(255) NOT NULL
);