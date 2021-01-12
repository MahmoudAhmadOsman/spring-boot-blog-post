import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
 

import { PostService } from 'src/app/services/post.service';
import { Post } from 'src/app/models/post.model';


@Component({
  selector: 'app-create-new-post',
  templateUrl: './create-new-post.component.html',
  styleUrls: ['./create-new-post.component.scss']
})
export class CreateNewPostComponent implements OnInit {
  creatTitle: string = 'Create New Post';
  post: Post = new Post();

  constructor(private postService: PostService, private router: Router) { }
  //Save the newly created book to the database
  savePost() {
    this.postService.createNewPost(this.post).subscribe(data => {
      console.log(data);
      //this.goToPostList();
      //this.router.navigate(['/posts']);
    }),
      error => console.log(error);
  }


  ngOnInit(): void {
    //this.goToPostList();
  }

  // goToPostList() {
  //   this.router.navigate(['/posts']);
  // }

  //When new post is submitted, run this function
  onSubmit() {
    this.savePost();
    //console.log(this.post);

  }




}
