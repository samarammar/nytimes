# NYTimes_Task
A simple application that represents NYtimes APIs for developers
We have used the api that representes most viewed articles in all section with the ability to show some simple
details about the article once you click on article item.

Appliction has very simple design but it's been developed with MVVM Clean Architecture 

I have also used
- Kotlin Coroutines (for asynchronous calls)
- Dagger Hilt ( for Dependency Injection )
- Kotlin FLow (for mapping and emitting data from data source to views) 

You can find code divided into 3 layers (CLean Architecture layers):
- Presentation (for views)
- Domain (for delivering data to presentation layer)
- Data (that has Data source interfaces and models)
and i have added Dependency Injection Modules Folder (DI) for NetworkModule.


You can notice the application in 100% developed in Kotlin.

You can check more of NYtimes apis from this link 
https://developer.nytimes.com/


