import { PostService } from './../../services/post.service';
import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post.model';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.scss'],
})
export class PostListComponent implements OnInit {
  title: string = 'Latest Posts';
  posts: Post[];

  constructor(private PostService: PostService) {}

  ngOnInit(): void {
    this.getAllPosts();
  }

  //Get list of posts
  getAllPosts() {
    this.PostService.getPostsList().subscribe((data) => {
      console.log(data);
      this.posts = data;
    });
  }
}
