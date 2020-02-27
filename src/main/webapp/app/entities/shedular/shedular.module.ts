import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EjbmavenSharedModule } from 'app/shared/shared.module';
import { ShedularComponent } from './shedular.component';
import { ShedularDetailComponent } from './shedular-detail.component';
import { ShedularUpdateComponent } from './shedular-update.component';
import { ShedularDeleteDialogComponent } from './shedular-delete-dialog.component';
import { shedularRoute } from './shedular.route';

@NgModule({
  imports: [EjbmavenSharedModule, RouterModule.forChild(shedularRoute)],
  declarations: [ShedularComponent, ShedularDetailComponent, ShedularUpdateComponent, ShedularDeleteDialogComponent],
  entryComponents: [ShedularDeleteDialogComponent]
})
export class EjbmavenShedularModule {}
