create table EventAssigneeTable (
	uuid_ VARCHAR(75) null,
	Id INTEGER not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	eventId INTEGER,
	assigneeId INTEGER
);

create table EventAttributes (
	id_ LONG not null primary key,
	attributeNumber VARCHAR(75) null,
	attributeName VARCHAR(75) null,
	eventId VARCHAR(75) null
);

create table EventFAQs (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	Question VARCHAR(75) null,
	Answer VARCHAR(75) null,
	eventId VARCHAR(75) null
);

create table EventHighLights (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	Title VARCHAR(75) null,
	Description VARCHAR(75) null,
	Image BLOB,
	eventId VARCHAR(75) null
);

create table EventSpeakers (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	position VARCHAR(75) null,
	speakerImage BLOB,
	speakerImageString VARCHAR(75) null,
	nationality VARCHAR(75) null,
	email VARCHAR(75) null,
	firstName VARCHAR(75) null,
	userId VARCHAR(75) null,
	lastName VARCHAR(75) null,
	isNotificationSent VARCHAR(75) null,
	eventId VARCHAR(75) null,
	isNotifEnabled VARCHAR(75) null
);

create table EventTimeline (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	Title VARCHAR(75) null,
	Description VARCHAR(75) null,
	EventStartDay DATE null,
	EventendDay DATE null,
	eventId VARCHAR(75) null
);

create table FOO_Foo (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);

create table ImageCalendar (
	uuid_ VARCHAR(75) null,
	Id LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	data_ BLOB,
	eventId VARCHAR(75) null
);

create table ProfileJobWishList (
	uuid_ VARCHAR(75) null,
	Id LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	jobwishlist VARCHAR(75) null
);

create table ProfileTestimonial (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	testimonialprovidername VARCHAR(75) null,
	testimonialprovideremail VARCHAR(75) null,
	testimonialprovorgname VARCHAR(75) null,
	testimonialprovidertitle VARCHAR(75) null,
	testimonialprivatemessage VARCHAR(75) null,
	imagePreview VARCHAR(75) null
);

create table RegisterEvent (
	uuid_ VARCHAR(75) null,
	Id LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	registeredUserId VARCHAR(75) null,
	eventId VARCHAR(75) null
);

create table TableNewTest (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	Title VARCHAR(75) null,
	Description VARCHAR(75) null,
	Image BLOB,
	eventId VARCHAR(75) null
);

create table formeventusertable (
	uuid_ VARCHAR(75) null,
	ID LONG not null primary key,
	userId VARCHAR(75) null,
	eventId VARCHAR(75) null,
	ddmFormInstanceId VARCHAR(75) null,
	ddmFormInstanceRecordVersionId VARCHAR(75) null,
	statusCol VARCHAR(75) null,
	formId VARCHAR(75) null,
	reviewerUserId VARCHAR(75) null,
	reviewerComments VARCHAR(75) null,
	ddmFormInstanceRecordVersion VARCHAR(75) null
);

create table journey (
	journeyId LONG not null primary key,
	userId VARCHAR(75) null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	pictureBlob BLOB
);

create table profileEducation (
	uuid_ VARCHAR(75) null,
	Id LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	profileId LONG,
	educationCategory VARCHAR(75) null,
	degree VARCHAR(75) null,
	fieldOfStudy VARCHAR(75) null,
	startYear VARCHAR(75) null,
	endYear VARCHAR(75) null,
	grade VARCHAR(75) null,
	description VARCHAR(75) null
);

create table profileImage (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	userId LONG,
	image BLOB
);

create table profileInfo (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	firstName VARCHAR(75) null,
	fatherName VARCHAR(75) null,
	grandfatherName VARCHAR(75) null,
	familyName VARCHAR(75) null,
	email VARCHAR(75) null,
	primaryMobileNo LONG,
	secondaryMobileNo LONG,
	gender VARCHAR(75) null,
	nationality VARCHAR(75) null,
	nationalId LONG,
	passportId LONG,
	passportExpireDate DATE null,
	dateOfBirth DATE null,
	currentEducationTrainingStatus VARCHAR(75) null,
	countryOfResidence VARCHAR(75) null,
	cityOfResidence VARCHAR(75) null,
	nationalAddress VARCHAR(75) null,
	postalCode VARCHAR(75) null,
	street VARCHAR(75) null,
	state_ VARCHAR(75) null,
	about VARCHAR(75) null,
	profileimage VARCHAR(75) null,
	universitygeneral VARCHAR(75) null,
	currentworkposition VARCHAR(75) null,
	currentworklocation VARCHAR(75) null,
	educationField VARCHAR(75) null,
	isEmailVerified VARCHAR(75) null,
	isMobileVerified VARCHAR(75) null
);

create table profileIntrest (
	uuid_ VARCHAR(75) null,
	Id LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	profileId LONG,
	intrest VARCHAR(75) null
);

create table profileLicensesCertifications (
	uuid_ VARCHAR(75) null,
	Id LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	profileId LONG,
	name VARCHAR(75) null,
	issuingOrganization VARCHAR(75) null,
	issueDate DATE null,
	expirationDate DATE null,
	credentialID LONG,
	credentialURL VARCHAR(75) null,
	notExpire BOOLEAN
);

create table profileSkills (
	uuid_ VARCHAR(75) null,
	Id LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	profileId LONG,
	skill VARCHAR(75) null
);

create table profileWorkExperience (
	uuid_ VARCHAR(75) null,
	Id LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	profileId LONG,
	title VARCHAR(75) null,
	company VARCHAR(75) null,
	location VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	description VARCHAR(75) null,
	currentWorkStatus VARCHAR(75) null,
	workExperience VARCHAR(75) null
);