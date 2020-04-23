To install:
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1. Download postgresql https://www.postgresql.org/download/windows/
with User: postgresql and Password: admin 
//Technically, you can choose any user or password, but choosing these would mean not having to modify the project every time you want to run it :)
2. Download pgadmin 4 https://www.pgadmin.org/download/
3. Download IntellijIDEA https://www.jetbrains.com/idea/
4. Download Java 1.8 (you need an Oracle account, good luck)
5. Download Gradle 4.6 (if intellij brings a newer version, downgrade to this one)
6. Run the project


To modify the project:
1. Make a new branch for any small change
2. Make a pull request and wait for approve

Don't push on master.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
###Request-Response bodies and available endpoint
Application runs on port 8080 so calls have to be made on **http://localhost:8080** and following endpoints:</br>  
**/user**
1. _Create a user:_ **POST** /user  </br>  
    - **Request body JSON**  
`{  
	"email": "test@test.com",
	"password": "1",                      
	"role": "admin"  
}`  
    - **Response body**  
Status code 200OK for success  
Status code 400BadRequest for failure

2. _Get all users:_ **GET** /user   </br>  
    - **Request body JSON**  
none
    - **Response body**  
    Status code 200OK for success  
`[
    {
        "id": 1,
        "email": "brigittemois@yahoo.com",
        "password": "1",
        "role": "admin"
    },
    {
        "id": 2,
        "email": "test@test.com",
        "password": "1",
        "role": "admin"
    }
]`
3. _Get user by id:_ **GET** /user/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
`{
    "id": 1,
    "email": "brigittemois@yahoo.com",
    "password": "1",
    "role": "admin"
}`

4. _Delete user by id:_ **DELETE** /user/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
Status code 500InternalServerError for failure  

5. _Update user by id:_ **PUT** /user   </br>  
**needs fixing - do not use**

6. _Check if user exists for login:_ **POST** /user/login   </br>  
    - **Request body JSON**  
`{  
	"email": "test@test.com",
	"password": "test",                      
}`
    - **Response body**  
Status code 200OK for success  
Status code 500InternalServerError for failure

**/pupil**  
1. _Create a pupil:_ **POST** /pupil  </br>  
    - **Request body JSON**  
`{  
	"email": "test@test.com",
	"password": "1",                      
	"role": "admin"
}`  
    - **Response body**  
Status code 200OK for success  
Status code 400BadRequest for failure

2. _Get all pupils:_ **GET** /pupil   </br>  
    - **Request body JSON**  
none
    - **Response body**  
    Status code 200OK for success  
`[
    {
        "id": 1,
        "email": "brigittemois@yahoo.com",
        "password": "1",
        "role": "admin"
    },
    {
        "id": 2,
        "email": "test@test.com",
        "password": "1",
        "role": "admin"
    }
]`
3. _Get pupil by id:_ **GET** /pupil/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
`{
    "id": 1,
    "email": "brigittemois@yahoo.com",
    "password": "1",
    "role": "admin"
}`

4. _Delete pupil by id:_ **DELETE** /pupil/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
Status code 500InternalServerError for failure  

5. _Update pupil by id:_ **PUT** /pupil   </br>  
**needs fixing - do not use**

**/teacher**  
1. _Create a teacher:_ **POST** /teacher/{userid}  </br>  
    - **Request body JSON**  
`{  
 	"firstname" : "firstnametest",
 	"lastname" : "lastnametest"
 }`  
    - **Response body**  
Status code 200OK for success  
Status code 400BadRequest for failure

2. _Get all teachers:_ **GET** /teacher   </br>  
    - **Request body JSON**  
none
    - **Response body**  
    Status code 200OK for success  
`[
     {
         "id": 1,
         "firstname": "firstnametest",
         "lastname": "lastnametest",
         "user": null,
         "subjects": []
     }
 ]`
3. _Get teacher by id:_ **GET** /teacher/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
`{
     "id": 1,
     "firstname": "firstnametest",
     "lastname": "lastnametest",
     "user": null,
     "subjects": []
 }`

4. _Delete teacher by id:_ **DELETE** /teacher/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
Status code 500InternalServerError for failure  

5. _Update teacher by id:_ **PUT** /teacher   </br>  
**needs fixing - do not use**

6. _Attach teacher to subject by id:_ **POST** /teacher/{teacherid}/subject/{subjectid}   </br>  
       - **Request body JSON**  
   none
       - **Response body**  
   Status code 200OK for success  
   Status code 500InternalServerError for failure  

**/classroom**  
1. _Create a classroom:_ **POST** /classroom  </br>  
    - **Request body JSON**  
`{  
 	"name": "12A"               
 }`  
    - **Response body**  
Status code 200OK for success  
Status code 400BadRequest for failure

2. _Get all classrooms:_ **GET** /classroom   </br>  
    - **Request body JSON**  
none
    - **Response body**  
    Status code 200OK for success  
`[
     {
         "id": 1,
         "teachers": null,
         "pupils": null,
         "catalog": null,
         "name": "12A"
     }
 ]`
3. _Get classroom by id:_ **GET** /classroom/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
`{
    "id": 1,
    "teachers": null,
    "pupils": null,
    "catalog": null,
    "name": "12A"
}`

4. _Delete classroom by id:_ **DELETE** /classroom/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
Status code 500InternalServerError for failure  

5. _Update classroom by id:_ **PUT** /classroom   </br>  
**needs fixing - do not use**

6. _Get all subjects for a given classroom id:_  **GET** /classroom/{id}/subject </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
Status code 500InternalServerError for failure  

**/catalog**  
1. _Create a catalog:_ **POST** /catalog/{classroomid}  </br>  
    - **Request body JSON**  
`{  
}`  
    - **Response body**  
Status code 200OK for success  
Status code 400BadRequest for failure

2. _Get all catalogs:_ **GET** /catalog   </br>  
    - **Request body JSON**  
none
    - **Response body**  
    Status code 200OK for success  
`[
     {
         "id": 1,
         "classroom": null
     }
 ]`
3. _Get catalog by id:_ **GET** /catalog/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
`{
    "id": 1,
    "classroom": null
}`

4. _Delete catalog by id:_ **DELETE** /catalog/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
Status code 500InternalServerError for failure  

5. _Update catalog by id:_ **PUT** /catalog   </br>  
**needs fixing - do not use**

**/grade**  
1. _Create a grade:_ **POST** /grade  </br>  
    - **Request body JSON**  
`{  
 	"pupil" : 2,
 	"subject" : 2,
 	"grade" : 2
 }`  
    - **Response body**  
Status code 200OK for success  
Status code 400BadRequest for failure

2. _Get all grades:_ **GET** /grade   </br>  
    - **Request body JSON**  
none
    - **Response body**  
    Status code 200OK for success  
`[
     {
         "id": 1,
         "catalog": null,
         "pupil": 2,
         "subject": 2,
         "grade": 2
     }
 ]`
3. _Get grade by id:_ **GET** /grade/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
`{
     "id": 1,
     "catalog": null,
     "pupil": 2,
     "subject": 2,
     "grade": 2
 }`

4. _Delete grade by id:_ **DELETE** /grade/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
Status code 500InternalServerError for failure  

5. _Update grade by id:_ **PUT** /grade   </br>  
**needs fixing - do not use**

**/subject** 
1. _Create a subject:_ **POST** /subject  </br>  
    - **Request body JSON**  
`{  
 	"name" : "matematica"
 }`  
    - **Response body**  
Status code 200OK for success  
Status code 400BadRequest for failure

2. _Get all subjects:_ **GET** /subject   </br>  
    - **Request body JSON**  
none
    - **Response body**  
    Status code 200OK for success  
`[
     {
         "id": 1,
         "teachers": null,
         "name": "matematica"
     }
 ]`
3. _Get subject by id:_ **GET** /subject/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
`{
    "id": 1,
    "teachers": null,
    "name": "matematica"
}
`
4. _Delete subject by id:_ **DELETE** /subject/{id}   </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
Status code 500InternalServerError for failure  

5. _Update subject by id:_ **PUT** /subject   </br>  
**needs fixing - do not use**

6. _Get all teachers for a given subject id:_  **GET** /teacher/subject/{id} </br>  
    - **Request body JSON**  
none
    - **Response body**  
Status code 200OK for success  
Status code 500InternalServerError for failure  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------