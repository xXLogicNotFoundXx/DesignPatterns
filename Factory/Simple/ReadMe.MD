
# Simple Factory(Static Factory) is not a pattern.

Simple Factory is where you create a class and use (Common Logic OR Conditions) to create different objects.\

Defining a simple factory as a static method is a common technique and is often called a static factory.\
Why use a static method? Because you don’t need to instantiate an object to make use of the create method.\

For eg:
in ASE :
PasswordManagementFoctory.createPasswordManagement() returns an object of PasswordManagement.\
**PasswordManagement** is an interface. This interface is implemented by **PasswordManagementSSOImpl & PasswordManagementImpl**.\
Depending on SSO setting we either return PasswordManagementSSOImpl or PasswordManagementImpl object.\
PasswordManagementSSOImp doesnt do anything related to password bcz SSO is on.


