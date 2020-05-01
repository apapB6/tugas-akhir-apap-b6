import React, { useState } from 'react';
import clsx from 'clsx';
import PropTypes from 'prop-types';
import PerfectScrollbar from 'react-perfect-scrollbar';
import { makeStyles } from '@material-ui/styles';
import {
	Card,
	CardActions,
	CardContent,
	Avatar,
	Table,
	TableBody,
	TableCell,
	TableHead,
	TableRow,
	Typography,
	TablePagination
} from '@material-ui/core';
import CreateIcon from '@material-ui/icons/Create';
import DeleteIcon from '@material-ui/icons/Delete';
import { getInitials } from 'helpers';
import { StatusBullet } from 'components';

const useStyles = makeStyles(theme => ({
	root: {},
	content: {
		padding: 0
	},
	inner: {
		minWidth: 1050
	},
	nameContainer: {
		display: 'flex',
		alignItems: 'center'
	},
	avatar: {
		marginRight: theme.spacing(2)
	},
	actions: {
		justifyContent: 'flex-end'
	},
	status: {
		marginRight: theme.spacing(1)
	}
}));

const statusColors = {
	tersedia: 'success',
	kosong: 'danger'
};

const BukuTable = props => {
	const { className, users, ...rest } = props;

	const classes = useStyles();
	const [rowsPerPage, setRowsPerPage] = useState(10);
	const [page, setPage] = useState(0);

	const handlePageChange = (event, page) => {
		setPage(page);
	};

	const handleRowsPerPageChange = event => {
		setRowsPerPage(event.target.value);
	};

	return (
		<Card
			{...rest}
			className={clsx(classes.root, className)}
		>
			<CardContent className={classes.content}>
				<PerfectScrollbar>
					<div className={classes.inner}>
						<Table>
							<TableHead>
								<TableRow>
									<TableCell>No</TableCell>
									<TableCell>Gambar</TableCell>
									<TableCell>Judul</TableCell>
									<TableCell>Pengarang</TableCell>
									<TableCell>Status</TableCell>
									<TableCell>Aksi</TableCell>
								</TableRow>
							</TableHead>
							<TableBody>
								{users.slice(0, rowsPerPage).map(user => (
									<TableRow
										className={classes.tableRow}
										hover
										key={user.id}
									>
										<TableCell>{users.indexOf(user) + 1}</TableCell>
										<TableCell>
											<Avatar
												className={classes.avatar}
												src={user.avatarUrl}
											>
												{getInitials(user.name)}
											</Avatar>
										</TableCell>
										<TableCell>APAP</TableCell>
										<TableCell>
											<div className={classes.nameContainer}>
												<Typography variant="body1">{user.name}</Typography>
											</div>
										</TableCell>
										<TableCell>
											<StatusBullet
												className={classes.status}
												color={statusColors["tersedia"]}
												size="sm"
											/> Tersedia
											</TableCell>
										<TableCell>
											<CreateIcon />
											<DeleteIcon />
										</TableCell>
									</TableRow>
								))}
							</TableBody>
						</Table>
					</div>
				</PerfectScrollbar>
			</CardContent>
			<CardActions className={classes.actions}>
				<TablePagination
					component="div"
					count={users.length}
					onChangePage={handlePageChange}
					onChangeRowsPerPage={handleRowsPerPageChange}
					page={page}
					rowsPerPage={rowsPerPage}
					rowsPerPageOptions={[5, 10, 25]}
				/>
			</CardActions>
		</Card>
	);
};

BukuTable.propTypes = {
	className: PropTypes.string,
	users: PropTypes.array.isRequired
};

export default BukuTable;
