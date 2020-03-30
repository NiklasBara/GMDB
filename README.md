# 1 Week Project: GMDB (Galvanize Movie Database) 

Using everything you’ve learned so far, this week you’ll build a fullstack application mocking the functionality of IMDB (which, if you aren’t familiar with, you can see [here]()). Below, you’ll find a list of stories which will guide both your front- and back-end implementation. 

These directions are intentionally vague. There is not one right way to do this. Use your best judgment, and be able to defend your decisions! 

The goal of this project is to solidify your understanding of fullstack development and to put into practice what you have learned. The goal is not to “get to done”. Finishing is not the goal. If you are able to finish, great! But if not, do not worry! Everyone on the team should work across the stack. You should work on both the front and back ends.

Some instructors will be available asynchronously, so if you run into something terribly difficult and your classmates aren’t able to support you, feel free to reach out via Discord. 

## Groups

Team 1 | Team 2 | Team 3 | Team 4
---|---|---|---
Halil | Jens | Hannes | Arne
Christopher | Niklas | Phillip | Christian Sonntag
Christian Junge | Björn Mau | Hendrik | René
Artur | Jan | Dennis | Robert
|| Mathias | Tim | Sebastian
|| Alois | Björn Ahrens | Davide


## Project Setup
Create an organization on GitHub (free tier only allows public repositories).
Create a repo for your client. One team member should use `create-react-app` to generate a Hello World client in preparation for development and push it to the repo.

Create a repo for your api. One team member should use `Spring Initializr` to generate a Hello World Spring Boot web app in preparation for development and push it to the repo. 

## Team Work
### Git
The team members can clone the repos and a pair should make a feature branch for each small amount of functionality they are working on. The following guide explains the workflow for integrating your code back into master. It mentions merging the code locally after it is approved, but using GitHub you can accept the pull request online -- you don’t have to merge it locally. Make sure you bring in latest code from master frequently.
[Feature Branch Workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/feature-branch-workflow)

### Tracking 
You should attempt to break larger stories down into smaller tasks, and take advantage of a tool like trello to assign work to pairs on the team and track progress. [Here is a tutorial](http://greenrivertech.net/resources/trello-instructions/sprintPlanning.html#index.php) that explains in good detail how to use trello that way. Do not worry about creating acceptance criteria, but breaking down the stories in to smaller tasks is a good idea.

### Ceremonies
You should hold a daily standup as a team to keep each other informed of what you accomplished yesterday, what you are working on today and what blockers/impediments you have. You should hold a retrospective at the end of the week to reflect on what went well and what could be improved.

## GMDB User Stories: 

Below are your user stories. You’ll notice they are written in a specific pattern: “As a [type of user], I want [some functionality] so that [some reason]”. This is a typical format you’ll see user stories written in, and we want you to get used to that! 

1. As a visitor of GMDB, I want to see a list of all available movies in the database that includes { Movie ID | Movie Title | Year Released | Genre | Runtime (minutes) | Rating } so that I can see what is available 
1. As a visitor of GMDB, I want to be able to see information/details about each video including list of reviews for the movie so I can learn more about it
1. As a visitor I want to provide a specific reviewer and get back their details and a list of all their reviews so I can read more content by reviewers I like
1. As a visitor of GMDB, I want to be able to provide a username to register for an account with GMDB as a “reviewer” so I can start reviewing movies
    * Don’t overcomplicate this -- use an MVP approach to implement authentication
1. As a reviewer, I want to be able to add/write a review for a movie I’ve seen so that other users will know what I think about this movie 
1. As a reviewer, I want to be able to rate movies (out of 5 stars) so that other users will know what I rate this movie out of 5
1. As a reviewer, I want to be able to add movies to my “watch list” so that I can keep track of the movies I’d like to see and review
1. As a reviewer, I want to be able to mark movies as watched so I can see my viewing history and which movies to watch next
1. As a reviewer, I want to be able to edit my review of a movie in case I change my mind 
1. As a reviewer, I want to be able to edit my rating of a movie in case I change my mind
1. As a reviewer, I want to be able to delete my review of a movie 
1. As a reviewer, I want to be able to delete my rating of a movie 
1. As a reviewer, I want to be able to delete a movie from my watch list in case I no longer wish to watch it
1. As a reviewer, I want to be able to delete movies from my “favorite movies” list so I can keep my favorites updated
1. As an admin of GMDB, I want my account to be registered as an “admin” account so I manage the site
1. As an admin, I want to be able to add movies to the database so that it can stay up-to-date
1. As an admin, I want to be able to update information/data about a specific movie in the database to keep it up to date
1. As an admin, I want to be able to edit reviews by reviewers to impersonate them so that I can provide help if they need technical support
1. As an admin, I want to be able to delete a movie & its data from the database so that it stays up to date
1. As an admin, I want to be able to delete reviews about a movie written by reviewers to prevent inappropriate reviews/spam
