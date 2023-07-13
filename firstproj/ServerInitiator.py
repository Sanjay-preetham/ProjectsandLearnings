from flask import Flask, request
from model.registration_model import Users
from service.reg_service import *
from sqlalchemy.orm import sessionmaker
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base

app = Flask(__name__)  

session=None
@app.route("/registers",methods=["POST"])
def reg_func():
    data=request.get_json()
    fname = data.get("fname")
    lname = data.get("lname")
    phnNum =data.get("phnNum")
    emailId = data.get("emailid")
    password = data["password"]
    result=regPost(fname,lname,phnNum,emailId,password,session)
    return result

@app.route("/login",methods=["POST"])
def log_func():
    data=request.get_json()
    emailId=data.get("emailId")
    password=data.get("password")
    login_result=logPost(emailId,password,session)
    return login_result


def init_db():
    username = 'root'
    password = 'Sanjay#1409'
    host = 'localhost'
    port = 3306
    db_name = "Project"
    init_engine(username,password,host,port,db_name)

def init_engine(username,password,host,port,db_name):
    global session
    engine = create_engine(f"mysql+pymysql://{username}:{password}@{host}:{port}/{db_name}",echo=True)
    Session = sessionmaker(bind=engine)
    session=Session()
    # Users.__table__.create(bind=engine, checkfirst=True)



if __name__ == '__main__':
    init_db()
    app.run(debug=True, port=5001)
    
