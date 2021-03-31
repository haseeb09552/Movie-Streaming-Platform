import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-movie-card',
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.css'],
})
export class MovieCardComponent implements OnInit {
  @Input() name: any;
  @Input() url: any;
  @Input() category: any;
  @Input() release: any;
  @Input() time: any;
  @Input() id: any;

  constructor() {}

  ngOnInit(): void {}
}
