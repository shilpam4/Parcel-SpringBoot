INSERT INTO	Parcel(Parcel_name,ordered_Dtm,aadhar_Of_User,last_modified_dtm)	
VALUES('Rahul','1996-10-12','SA74562024',CURRENT_TIMESTAMP);
 
INSERT INTO Address (parcel_id,Flatno,Street,City,state,Country,last_modified_dtm)
VALUES(1,'Flat no 7/22','Doon Chowki','Dehradun','Dehradun','Utttarakhand','2021-01-14T14:35:50.401+00:00');
 
INSERT INTO Telephone(parcel_id,Country_Code,Area_Code,cntrl_number,unique_number,last_modified_dtm)
VALUES(1,'+91','987','654','3210', '2021-01-14T14:35:50.401+00:00');

INSERT INTO Address (parcel_id,Flatno,Street,City,state,Country,last_modified_dtm)
VALUES(1,'Flat no 7/22 shilpu ka payara cute flat','Doon Chowki','Dehradun','Dehradun','Utttarakhand','2021-02-14T14:35:50.401+00:00');
 
INSERT INTO Telephone(parcel_id,Country_Code,Area_Code,cntrl_number,unique_number,last_modified_dtm)
VALUES(1,'+91','987','654','3120', '2021-02-14T14:35:50.401+00:00');