INSERT INTO	Parcel(Parcel_name,ordered_Dtm,aadhar_Of_User,last_modified_dtm)	
VALUES('Rahul','1996-10-12','SA74562024',CURRENT_TIMESTAMP);
 
INSERT INTO Address (parcel_id,Flatno,Street,City,state,Country,last_modified_dtm)
VALUES(1,'Flat no 7/22','Doon Chowki','Dehradun','Dehradun','Utttarakhand',CURRENT_TIMESTAMP);
 
INSERT INTO Telephone(parcel_id,Country_Code,Area_Code,cntrl_number,unique_number,last_modified_dtm)
VALUES(1,'+91','987','654','3210',CURRENT_TIMESTAMP);
