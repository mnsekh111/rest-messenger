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
db.Users.find({"name" : "Sekhar3"});
db.Users.find({"phone" : {$lte:4500000}});

//And conditional
db.Users.find({"name" : "Sekhar3","phone":232340});

//Or conditional
db.Users.find({
    $or:[{"name" : "Sekhar3"},{"phone":232340}]
});

//Update only one match
db.Users.update(
    {"name":"Sekhar3"},
    {$set:{"name":"SekharUpdated"}}
);
    
//Update all
db.Users.update(
    {"name":"Sekhar3"},
    {$set:{"name":"SekharUpdated","phone":0000000000}},
    {multi:true}
);
    
db.Users.save(
    {"name":"Sekhar3"},
    {$set:{"name":"SekharUpdated"}},
    {multi:true}
);

db.Users.updateMany(
    {"name":"SekharUpdated"},
    {$set:{"name":"Sekhar3"}}
);


//Delete an object id
db.Users.deleteOne(
    {
        "_id":ObjectId("577df7e0aa5fce11ac8e987a")
    }
)


//Find all
db.Users.find();
