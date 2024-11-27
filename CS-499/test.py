from animal_shelter import AnimalShelter
# now need to create the object from the class
shelter = AnimalShelter("aacuser", "password")
data = {"age_upon_outcome":"1.7 years","animal_type":"Cat"}
if shelter.create(data):
    print("animal added")
    else:
        print("No animal added")
# Read from the object class
for document in data:
    print(document)