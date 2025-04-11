import {Directive, ElementRef, HostListener, inject, Renderer2} from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {

  private elementWithSelector = inject(ElementRef);

  @HostListener('mouseenter') onMouseEnter() {
    this.elementWithSelector.nativeElement.classList.add('bg-body-secondary');
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.elementWithSelector.nativeElement.classList.remove('bg-body-secondary');
  }

}
