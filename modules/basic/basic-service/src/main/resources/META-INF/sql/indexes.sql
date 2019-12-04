create index IX_5637869F on EventAssigneeTable (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CADF28E1 on EventAssigneeTable (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E0CE7357 on EventFAQs (uuid_[$COLUMN_LENGTH:75$]);

create index IX_7BA56ED5 on EventHighLights (uuid_[$COLUMN_LENGTH:75$]);

create index IX_4777BA00 on EventSpeakers (uuid_[$COLUMN_LENGTH:75$]);

create index IX_2129A0B3 on EventTimeline (uuid_[$COLUMN_LENGTH:75$]);

create index IX_B2FCA947 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_905CD589 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F4A74753 on ImageCalendar (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6BEF8695 on ImageCalendar (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_EC456D33 on ProfileJobWishList (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_569DA475 on ProfileJobWishList (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_ECDAE490 on ProfileTestimonial (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D5F34F12 on ProfileTestimonial (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_7B76E051 on RegisterEvent (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CB2D4713 on RegisterEvent (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_2D12D8EA on TableNewTest (uuid_[$COLUMN_LENGTH:75$]);

create index IX_756C2A81 on formeventusertable (uuid_[$COLUMN_LENGTH:75$]);

create index IX_E0C536B9 on profileEducation (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BD6E177B on profileEducation (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C2ACE23C on profileImage (uuid_[$COLUMN_LENGTH:75$]);

create index IX_9F6A24B1 on profileInfo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B9E62373 on profileInfo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9D10A194 on profileIntrest (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D3BC7D16 on profileIntrest (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_26811B2E on profileLicensesCertifications (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_AA529530 on profileLicensesCertifications (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_2E482005 on profileSkills (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D8F2E3C7 on profileSkills (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_93489B9E on profileWorkExperience (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6DF71A0 on profileWorkExperience (uuid_[$COLUMN_LENGTH:75$], groupId);