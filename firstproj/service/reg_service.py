from model.registration_model import Users
from flask import make_response,jsonify

def regPost(fname, lname, phnNum, emailId, password, session):
    print(session)
    print("landed")
    print(fname,lname,emailId,phnNum,password)
    existing_user = session.query(Users).filter(Users.emailId==emailId).first()
    if existing_user:
        response= {
        'message': 'Successfully logged in!',
        'status': 201
    }
    else:
        user = Users(fname=fname, lname=lname, phnnum=phnNum, emailId=emailId, password=password)
        session.add(user)
        session.commit()
        response = {
        'message': 'Error',
        'status': 401
        }
        
    return jsonify(response)

def logPost(emailId,password,session):
    user=session.query(Users).filter(Users.emailId==emailId, Users.password==password).first()
    if user:
         response = {
        'message': 'Successfully logged in!',
        'status': 201
    }
    
    else:
       response = {
        'message': 'Error',
        'status': 401
        }
       
    return jsonify(response)

    