#pip install pymongo
from pymongo import MongoClient

# Connect to MongoDB server
client = MongoClient("mongodb://localhost:27017/")  # Change connection string if necessary

# Select the database and collection
db = client["LibraryDB"]
books_collection = db["Books"]

# Create some sample books
def insert_books():
    books = [
        {"Name": "Understanding MongoDB", "Pages": 200},
        {"Name": "Advanced Python Programming", "Pages": 800},
        {"Name": "Learning JavaScript", "Pages": 350},
        {"Name": "Introduction to Databases", "Pages": 50},
        {"Name": "MongoDB for Developers", "Pages": 1000}
    ]
    books_collection.insert_many(books)
    print("Books inserted.")

# Perform the Aggregation operation to replace MapReduce
def aggregate_books():
    # Define the aggregation pipeline
    pipeline = [
        {
            "$group": {
                "_id": {
                    "$cond": {"if": {"$gte": ["$Pages", 500]}, "then": "Big book", "else": "Small book"}
                },
                "count": {"$sum": 1}
            }
        }
    ]
    
    # Run the aggregation
    result = books_collection.aggregate(pipeline)
    
    # Show the results
    print("\nAggregation Result:")
    for doc in result:
        print(f"Category: {doc['_id']}, Count: {doc['count']}")

# Main function to execute all operations
def main():
    # Insert sample book data
    insert_books()
    
    # Perform the Aggregation operation
    aggregate_books()
    
    # Close the MongoDB client connection
    client.close()
    print("MongoDB connection closed.")

# Run the program
if __name__ == "__main__":
    main()
