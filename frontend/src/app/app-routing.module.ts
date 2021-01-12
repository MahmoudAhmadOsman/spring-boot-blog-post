import { HomeComponent } from './components/home/home.component';
import { PostListComponent } from './components/post-list/post-list.component';
import { AppComponent } from './app.component';
import { AddPostComponent } from './components/add-post/add-post.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
 
   { path: '', pathMatch: 'full', component: HomeComponent },
  { path: 'posts', component: PostListComponent },
  { path: "add-post", component: AddPostComponent },

  
//  { path: "blogs", component: PostListComponent,
//       children: [
//         { path: "add-post", component: AddPostComponent },
//         { path: "post-details", component: AddPostComponent },
//       ]
//   },
 

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
