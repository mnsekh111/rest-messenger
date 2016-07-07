//get the name of the database
db;

//create a collection
db.createCollection("Users")

//Get all collection names in the database
db.getCollectionNames()

//Get the count of documents
db.Users.count();

//drop the collection Users
db.Users.drop();

//Insert into collections Users
db.Users.insert({"name":"Sekhar",phone:232342});
db.Users.insert({"name":"Sekhar2",phone:4385798});

//Insert multiple elements
db.Users.insert([
    {
        "name":"Sekhar3",
         phone:232340
    },
    {
        "name":"Sekhar4",
         phone:232341
    }
    
]);
db.Users.find({"name" : "Sekhar"});

db.Users.find({"phone" : {$lte:4500000}});

//Find all
db.Users.find();
