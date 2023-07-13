from sqlalchemy import Column, Integer, String
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()

class Users(Base): 
    __tablename__="employees"
    __table_args__={"schema":"Project"}
    id=Column(Integer, primary_key=True, autoincrement=True)
    fname=Column(String(50),nullable=False)
    lname=Column(String(50), nullable=True)
    phnnum=Column(String(20), nullable=True)
    emailId=Column(String(50),nullable=False)
    password=Column(String(50),nullable=True)



