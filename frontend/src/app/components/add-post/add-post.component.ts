
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
 
import { PostService } from 'src/app/services/post.service';
import { Post } from 'src/app/models/post.model';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.scss']
})
export class AddPostComponent implements OnInit {

  addPostTitle: string = 'Create New Post';
  post: Post = new Post();

  constructor(private postService: PostService, private router: Router) { }
  //Save the newly created book to the database
  savePost() {
    this.postService.createNewPost(this.post).subscribe(data => {
      console.log(data);
      this.goToPostList();
      //this.router.navigate(['/']);
    }),
      error => console.log(error);
  }




  goToPostList() {
    this.router.navigate(['/posts']);
  }
 
  //When new post is submitted, run this function
  onSubmit() {
    this.savePost();
    console.log(this.post);

  }

  ngOnInit(): void {
    this.goToPostList();
  }

}
