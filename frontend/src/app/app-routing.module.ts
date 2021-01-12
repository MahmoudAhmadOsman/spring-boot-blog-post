import { CreateNewPostComponent } from './components/create-new-post/create-new-post.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { PostListComponent } from './components/post-list/post-list.component';
import { AppComponent } from './app.component';
 
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
 
   { path: '', pathMatch: 'full', component: HomeComponent },
  { path: 'posts', component: PostListComponent },
 
  {
    path:"add-new-post", component: CreateNewPostComponent
  },
  {
path:"contact", component: FooterComponent
  },

  
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
