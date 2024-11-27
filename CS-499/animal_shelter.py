from pymongo import MongoClient
from bson.objectid import ObjectId

class AnimalShelter(object):
    """ CRUD operations for Animal collection in MongoDB """
    
    def __init__(self, username, password):
        # Initializing the MongoClient without authentication
        #self.client = MongoClient('mongodb://localhost:27017')
        # access the MongoDB databases and collections. 
        self.client = MongoClient('mongodb://%s:%s@localhost:27017/?authMechanism=DEFAULT&authSource=AAC'%(username, password))
        self.database = self.client['AAC']

        # Create method to implement the C in CRUD.
    def create(self, data):
        if data is not None:
            self.database.animals.insert(data)  # data should be dictionary  
            return True
        else:
            raise Exception("Nothing to save, because data parameter is empty")

       
    # Query the database to return a Cursor containing the first matching entry.
    def readOne(self, data):
        if data is not None:
            return self.database.animals.find_one(data) # return one document as a python dictionary
        else:
            raise Exception("nothing to read because data parameter is empty")
            

    # Query the database to return a Cursor containing all matching entries.
    def readAll(self, data):
        if data is not None:
            return self.database.animals.find(data,{"_id":False}) # return a cursor which a pointer to a list of results (Documents)
        else:
            raise Exception("nothing to read because data parameter is empty")
    
    # Query the database to update all matching entries.
    def update(self, data, update_key, update_value):
        if data is not None:
            result = self.database.animals.update_many(data, {'$set':{update_key:update_value}}) # return a cursor which a pointer to an update list of results 
            return result.raw_result
        else:
            raise Exception("Nothing to update, because data parameter is empty")
            
    # Query the database to delete all matching entries.
    def delete(self, data):
        if data is not None:
            result = self.database.animals.delete_many(data) # return a cursor which a pointer to delete list of results 
            return result.raw_result
        else:
            raise Exception("nothing to read because data parameter is empty")
